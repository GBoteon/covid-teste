package ps2.restapidb;

import ps2.restapidb.model.Funcionario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LerCSV_Funcionario {

    private BufferedReader lerGenerico(InputStream is) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }

        return br;
    }

    public ArrayList<Funcionario> lerUsuario(InputStream is) {

        BufferedReader br = lerGenerico(is);
        String linha = "";

        ArrayList<Funcionario> listFuncionarios = new ArrayList<Funcionario>();
        try {
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                int matricula;
                try {
                    matricula = Integer.parseInt(dados[6].replace("\"", "").trim());
                } catch (NumberFormatException nfe) {
                    matricula = 0;
                }

                listFuncionarios.add(new Funcionario(
                    dados[0].replace("\"", "").trim(),
                    dados[1].replace("\"", "").trim(),
                    dados[2].replace("\"", "").trim(),
                    dados[3].replace("\"", "").trim(),
                    dados[4].replace("\"", "").trim(),
                        Integer.parseInt(dados[5].replace("\"", "").trim()), matricula
                ));
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return listFuncionarios;
    }

}
