package EmailReport;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

class SendAttachment {
    public static void main(String[] args) {

        String to = "govind.soni@capgemini.com";// change accordingly
        final String user = "gsoni@mgmresorts.com";// change accordingly
        final String password = "Mgm@12345";// change accordingly

        // 1) get the session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.office365.com");// change accordingly
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        // 2) compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Message Aleart");

            // 3) create MimeBodyPart object and set your message content
            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText("This is message body");

            // 4) create new MimeBodyPart object and set DataHandler object to
            // this object
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            String filename = "SendAttachment.java";// change accordingly
            DataSource source = new FileDataSource(filename);
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName(filename);

            // 5) create Multipart object and add MimeBodyPart objects to this
            // object
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart2);

            // 6) set the multiplart object to the message object
            message.setContent(multipart);

            // 7) send message
            Transport.send(message);

            System.out.println("message sent....");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}