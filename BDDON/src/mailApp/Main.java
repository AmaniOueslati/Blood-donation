/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mailApp;
import java.util.List;


/**
 *
 * @author wesla
 */
public class Main {

   public static void main(String[] args) {
        List<String> recipients = List.of("weslatiamani86@gmail.com", "jazinadia7@gmail.com" , "eyaweslati33@gmail.com");
        MailApp.sendMail(recipients);
    }
}
