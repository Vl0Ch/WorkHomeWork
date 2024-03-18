package org.example;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.net.URL;

//TIP wow you're a boykisser OwO
public class Main {
   public static void main(String[] args) throws IOException {

      String body = "{\"description\":\n" +
              "        { \"participantInn\": \"string\" }, \"doc_id\": \"string\", \"doc_status\": \"string\",\n" +
              "        \"doc_type\": \"LP_INTRODUCE_GOODS\", 109 \"importRequest\": true,\n" +
              "        \"owner_inn\": \"string\", \"participant_inn\": \"string\", \"producer_inn\":\n" +
              "        \"string\", \"production_date\": \"2020-01-23\", \"production_type\": \"string\",\n" +
              "        \"products\": [ { \"certificate_document\": \"string\",\n" +
              "        \"certificate_document_date\": \"2020-01-23\",\n" +
              "        \"certificate_document_number\": \"string\", \"owner_inn\": \"string\",\n" +
              "        \"producer_inn\": \"string\", \"production_date\": \"2020-01-23\",\n" +
              "        \"tnved_code\": \"string\", \"uit_code\": \"string\", \"uitu_code\": \"string\" } ],\n" +
              "        \"reg_date\": \"2020-01-23\", \"reg_number\": \"string\"}";

      URL url = new URL("https://ismp.crpt.ru/api/v3/lk/documents/create");

      HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
      conn.setRequestMethod("POST");
      conn.setDoOutput(true);
      conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

      try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
         dos.writeBytes(body);
      }

      System.out.println("Response code: " + conn.getResponseCode());
      try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
         String line;
         while ((line = bf.readLine()) != null) {
            System.out.println(line);
         }
      }
   }
}