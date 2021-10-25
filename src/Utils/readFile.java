/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Cliente.Cliente;
import ConexcionDB.SQLDB;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SANTIAGO ESPINAL
 */
public class readFile {

    public void getTables(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        SQLDB SQLsentences = new SQLDB();
        List<String> mesas = new ArrayList<>();
        String StrAuxWhere = "", StrAuxHaving = "";
        boolean aux1 = false, aux2 = false;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        cadena = b.readLine();
        mesas.add(cadena);
        while ((cadena = b.readLine()) != null) {

            switch (cadena.substring(0, 2)) {
                case "TC" -> {
                    if (aux1) {
                        StrAuxWhere += " AND client.type = " + cadena.substring(3);
                    } else {
                        StrAuxWhere += "where client.type = " + cadena.substring(3);
                        aux1 = true;
                    }

                }
                case "UG" -> {
                    if (aux1) {
                        StrAuxWhere += " AND client.location = " + cadena.substring(3);
                    } else {
                        StrAuxWhere += "where client.location = " + cadena.substring(3);
                        aux1 = true;
                    }

                }
                case "RI" -> {

                    if (aux2) {
                        StrAuxHaving += " AND sum(account.balance) > " + cadena.substring(3);
                    } else {
                        StrAuxHaving += "HAVING sum(account.balance) > " + cadena.substring(3);
                        aux2 = true;
                    }

                }
                case "RF" -> {

                    if (aux2) {
                        StrAuxHaving += " AND sum(account.balance) < " + cadena.substring(3);
                    } else {
                        StrAuxHaving += "HAVING sum(account.balance) < " + cadena.substring(3);
                        aux2 = true;
                    }

                }
            }

            if (cadena.contains("<")) {

                List<Cliente> clientes = SQLsentences.GetClients(StrAuxWhere, StrAuxHaving);
                clientes = DeleteClients.sameSex(clientes);
                clientes = DeleteClients.excess(clientes);
                clientes = DeleteClients.sameCompany(clientes);
                clientes = DeleteClients.sameSex(clientes);
                System.out.println(mesas.get(mesas.size() - 1));
                System.out.println("");
                if (clientes.size() < 4) {
                    System.out.println("CANCELADA\n");
                    
                } else {
                    boolean x = true;
                    for (Cliente cliente : clientes) {
                        if (x) {
                            System.out.print(cliente.getCode());
                            x = false;
                        } else {
                            System.out.print("," + cliente.getCode());
                        }

                    }
                    System.out.println("\n");
                    
                }

                aux1 = false;
                aux2 = false;
                StrAuxWhere = "";
                StrAuxHaving = "";
                mesas.add(cadena);
            }

        }

        List<Cliente> clientes = SQLsentences.GetClients(StrAuxWhere, StrAuxHaving);
        clientes = DeleteClients.sameSex(clientes);
        clientes = DeleteClients.excess(clientes);
        clientes = DeleteClients.sameCompany(clientes);
        clientes = DeleteClients.sameSex(clientes);
        System.out.println(mesas.get(mesas.size() - 1)+"\n");
        
        if (clientes.size() < 4) {
            System.out.println("CANCELADA");
        } else {
            boolean x = true;
            for (Cliente cliente : clientes) {
                if (x) {
                    x = false;
                    System.out.print(cliente.getCode());
                } else {
                    System.out.print("," + cliente.getCode());
                }

            }
        }
        b.close();
    }

}
