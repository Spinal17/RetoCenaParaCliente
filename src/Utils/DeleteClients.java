/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Cliente.Cliente;
import java.util.List;

/**
 *
 * @author SANTIAGO ESPINAL
 */
public class DeleteClients {

    public static List<Cliente> excess(List<Cliente> clientes) {

        if (clientes.size() > 7) {
            for (int i = clientes.size() - 1; i > 7; i--) {
                clientes.remove(i);
            }
        }
        return clientes;
    }

    public static List<Cliente> sameCompany(List<Cliente> clientes) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente get = clientes.get(i);
            for (int j = 0; j < clientes.size(); j++) {
                if (i != j && get.getCompany() == clientes.get(j).getCompany()) {
                    clientes.remove(j);
                    i--;
                    j--;
                }

            }

        }
        return clientes;
    }

    public static List<Cliente> sameSex(List<Cliente> clientes) {
        int male = 0, famale = 0;
        boolean x = true;
        while (x) {
            male = 0;
            famale = 0;
            for (Cliente cliente : clientes) {
                if (cliente.isMale()) {
                    male++;
                } else {
                    famale++;
                }
            }
            
            if (male == famale) {
                x = false;
                return clientes;
            } else {

                if (male > famale) {
                    int index = clientes.size() - 1;
                    boolean aux = true;
                    while (aux) {
                        if (clientes.get(index).isMale()) {
                            clientes.remove(index);
                            aux = false;
                        } else {
                            index--;
                        }
                    }

                } else {
                    int index = clientes.size() - 1;
                    boolean aux = true;
                    while (aux) {
                        if (!clientes.get(index).isMale()) {
                            clientes.remove(index);
                            aux = false;
                        } else {
                            index--;
                        }
                    }
                }

            }
        }

        return clientes;
    }

}
