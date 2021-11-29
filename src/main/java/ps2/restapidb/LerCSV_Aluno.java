package ps2.restapidb;

import ps2.restapidb.model.Aluno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LerCSV_Aluno{

    private BufferedReader lerGenerico(InputStream is) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }

        return br;
    }

    public ArrayList<Aluno> lerUsuario(InputStream is) {

        BufferedReader br = lerGenerico(is);
        String linha = "";

        ArrayList<Aluno> listAlunos = new ArrayList<Aluno>();
        try {
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                int matricula;
                try {
                    matricula = Integer.parseInt(dados[6].replace("\"", "").trim());
                } catch (NumberFormatException nfe) {
                    matricula = 0;
                }

                listAlunos.add(new Aluno(
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

        return listAlunos;
    }

}
