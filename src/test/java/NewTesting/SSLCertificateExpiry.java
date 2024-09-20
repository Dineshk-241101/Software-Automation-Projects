package NewTesting;

import java.io.FileOutputStream;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import org.apache.xmlbeans.XmlCursor.ChangeStamp.*;
import org.apache.xmlbeans.XmlCursor.ChangeStamp.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SSLCertificateExpiry {

    private static final String FILE_NAME = "SSL_Certificates1.xlsx";

    public static void main(String[] args) {
        List<String> domainList = Arrays.asList("https://play.predchamp.com");

        List<String> certificateFoundLogs = new ArrayList<>();
        List<String> certificateNotFoundLogs = new ArrayList<>();

        for (String domain : domainList) {
            for (int i = 1; i <= 99; i++) {
                String modifiedDomain = domain.replace("play", "play" + String.format("%02d", i));
                try {
                    printSSLCertificateExpiryDate(modifiedDomain, certificateFoundLogs, certificateNotFoundLogs);
                } catch (SSLHandshakeException e) {
                    certificateNotFoundLogs.add("Certificate not found for domain: " + modifiedDomain);
                } catch (Exception e) {
                    System.err.println("Error processing domain: " + modifiedDomain);
                    e.printStackTrace();
                }
            }
        }

        writeToExcel(certificateFoundLogs, certificateNotFoundLogs);
    }

    public static void printSSLCertificateExpiryDate(String urlString, List<String> certificateFoundLogs, List<String> certificateNotFoundLogs) throws Exception {
        HttpsURLConnection conn = null;
        try {
            URL url = new URL(urlString);
            conn = (HttpsURLConnection) url.openConnection();
            conn.connect();

            for (java.security.cert.Certificate cert : conn.getServerCertificates()) {
                if (cert instanceof X509Certificate) {
                    X509Certificate x509Cert = (X509Certificate) cert;
                    certificateFoundLogs.add(String.format("Domain: %s\nCertificate issue date: %s\nCertificate expiry date: %s\n",
                            urlString, x509Cert.getNotBefore(), x509Cert.getNotAfter()));
                    return; // Exit after logging details of the first certificate found
                }
            }

            certificateNotFoundLogs.add("Certificate not found for domain: " + urlString);

        } catch (SSLHandshakeException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Error retrieving SSL certificate for domain: " + urlString, e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public static void writeToExcel(List<String> certificateFoundLogs, List<String> certificateNotFoundLogs) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("SSL Certificates");

        int rownum = 0;

        // Write certificate found logs
        for (String log : certificateFoundLogs) {
            Row row = sheet.createRow(rownum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(log);
        }

        // Write certificate not found logs
        for (String log : certificateNotFoundLogs) {
            Row row = sheet.createRow(rownum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(log);
        }

        // Write to Excel file
        try (FileOutputStream outputStream = new FileOutputStream(FILE_NAME)) {
            workbook.write(outputStream);
            System.out.println("Excel file has been generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
