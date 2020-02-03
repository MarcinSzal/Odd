package pl.com.aay.pageObject;

import com.google.gson.Gson;
import org.codehaus.jackson.JsonNode;

import org.codehaus.jackson.map.ObjectMapper;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class  ReadDataFromFile {

    protected String path = "./src/test/resources/pl/com/aay/test_data/";
    protected String fileNeme = "registration3.json";

    public DataFromJson readFromGson() throws IOException {
        Gson gson = new Gson();
        DataFromJson registration;
        registration = gson.fromJson(new FileReader(path + fileNeme), DataFromJson.class);

        return registration;
    }

    public void readFromJackson() {
        JsonNode node  = null;
        StringBuilder jsonReader = new StringBuilder();

        try (BufferedReader in = new BufferedReader(new FileReader(path + fileNeme))) {
             String s;

             while((s=in.readLine())!=null){
                    jsonReader.append(s).append("\n");
             }
        }
        catch (IOException e) {
            System.err.println("jghhjgjg");
        }
        ObjectMapper mapper = new ObjectMapper();

        try{
             node = mapper.readTree(jsonReader.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }

        DataFromJson data = new DataFromJson();

        data.FirstName = node.findValue("FirstName").asText();
        data.Address=node.findValue("Address").asText();
        data.Address2 = node.findValue("Address").asText();
        data.City=node.findValue("City").asText();
        data.Email=node.findValue("Email").asText();
        data.LastName = node.findValue("LastName").asText();
        data.Phone = node.findValue("Phone").asText();
        data.StateProvince = node.findValue("StateProvince").asText();
        data.ConfirmP = node.findValue("ConfirmP").asText();
        data.Country = node.findValue("Country").asText();
        data.PostalCode = node.findValue("PostalCode").asText();
        data.Password = node.findValue("Password").asText();
        data.UserName = node.findValue("UserName").asText();
        data.SelectValue = node.findValue("SelectValue").asText();
    }
}
