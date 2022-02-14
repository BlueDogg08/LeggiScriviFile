package com.example.leggiscrivifile;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gestore {
    public String leggiFile(String nomeFile, Context c){
        StringBuilder sb = new StringBuilder(); //E' una classe che viene utilizzata per creare oggetti stringa
        try{ //ha la funzione di gestire le eccezioni. Si racchiude in un blocco try l'eventuale eccezione seguita da uno o più blocchi catch contenenti le istruzioni da eseguire in corrispondenza dell'eccezione lanciata
            BufferedReader fileDaLeggere = new BufferedReader(new InputStreamReader(c.openFileInput(nomeFile)));
            //InputStream è il metodo per ottenere informazioni da una risorsa. Cattura i dati byte per byte senza eseguire alcun tipo di traduzione
            String daRestituire = "";
            while((daRestituire = fileDaLeggere.readLine())!=null){//BufferedReader fornisce il metodo readLine() che legge una stringa, ma non ha metodi per leggere, ad esempio, interi o double.
                sb.append(daRestituire);
            }
        } catch (FileNotFoundException e){
            Log.e("errGestore", "File inesistente");
        } catch (IOException e) {
            e.printStackTrace();//printStackTrace è un metodo che visualizza un messaggio di errore nella console
        }

        return sb.toString();
    }

    public String scriviFile(String nomeFile, Context c){
        String esito;
        FileOutputStream fileO; //OutputStream è una classe astratta che rappresenta l'output di scrittura
        try {
            String str = "Questo è il messaggio";
            fileO = c.openFileOutput(nomeFile,
                    Context.MODE_PRIVATE);
            fileO.write(str.getBytes());
            fileO.close();
            esito = "File scritto correttamente";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            esito = "Impossibile creare file";
        } catch (IOException e) {
            e.printStackTrace();
            esito = "Impossibile scrivere nel file";
        }
        return esito;
    }
}