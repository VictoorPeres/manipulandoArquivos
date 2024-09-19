package br.com.avancard;

import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscreveJSON {

    public static void main(String[] args) throws IOException {

        Usuario usuario = new Usuario();
        usuario.setNome("Victor Oliveira");
        usuario.setCpf("01071155229");
        usuario.setLogin("Victor");
        usuario.setSenha("123MA");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Emerson");
        usuario2.setCpf("69696969696");
        usuario2.setLogin("Cabelinho");
        usuario2.setSenha("mimim");

        Usuario usuario3 = new Usuario();
        usuario3.setNome("Lurdes");
        usuario3.setCpf("69696969696");
        usuario3.setLogin("lurdinha");
        usuario3.setSenha("123VA");

        List<Usuario> usuarios = new ArrayList<Usuario>();

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Linha para formatar o código no arquivo
        String jsonUser = gson.toJson(usuarios);
        System.out.println(jsonUser);

        FileWriter fileWriter = new FileWriter("C:\\Users\\Samsung\\IdeaProjects\\arquivos\\src\\main\\java\\br\\com\\avancard\\filjson.json");
        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();

        //***---------------------------LENDO ARQUIVO JSON----------------***

        FileReader fileReader = new FileReader("C:\\Users\\Samsung\\IdeaProjects\\arquivos\\src\\main\\java\\br\\com\\avancard\\filjson.json");

        JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);

        List<Usuario> listUsuarios = new ArrayList<Usuario>();

        for(JsonElement jsonElement : jsonArray){
            Usuario usuario1 = new Gson().fromJson(jsonElement, Usuario.class);
            listUsuarios.add(usuario1);
        }

        System.out.println(listUsuarios);

    }
}
