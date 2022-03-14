/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sofka.bingo.Controllers;

import com.sofka.bingo.Models.Game;
import com.sofka.bingo.Services.GameService;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diego
 * 
 * Controlador en donde actualmente se encuentran las rutas de creacion del juego y creacion de tarjetones para jugar el bingo
 */
@CrossOrigin(value = "*")
@Slf4j
@RestController
public class GameController {

    private GameService gamser;

    
    /**
     * 
     * @return Un set de balotas que se van a jugar en el bingo
     * Estas balotas se guardan en el set y se dejan disponibles para consumir desde el front y mostrarlas al cliente
     */
    @RequestMapping(value = "game", method = RequestMethod.GET)
    public Set<String> create() {
        //Game g=new Game();
        //gamser.createGame(g);

        Set<String> arraybal = new LinkedHashSet<String>();

        do {
            String bal = "";
            int num = (int) Math.floor(Math.random() * (75 - 1 + 1) + 1);
            if (num > 0 && num < 16) {
                bal = "B" + num;

            } else if (num > 15 && num < 31) {
                bal = "I" + num;
            } else if (num > 29 && num < 46) {
                bal = "N" + num;
            } else if (num > 45 && num < 61) {
                bal = "G" + num;
            } else {
                bal = "O" + num;
            }

            arraybal.add(bal);
  
        } while (arraybal.size() < 75);
               
        return arraybal;
        
    }
    
    /**
     * 
     * @param session
     * @return Con este metodo se retorna un set que contiene los numeros del tarjeton
     * se utiliza HttpSession para asegurar que en caso de actualizar la pestaña no se pierdan los numeros asignados
     */
    
    @RequestMapping(value = "sheet", method = RequestMethod.GET)
    public List<Set> createsheet(HttpSession session){
        
            List<Set> carton = (List<Set>) session.getAttribute("sheet");
            
            if (carton == null) {
			carton = new ArrayList<>();
                        session.setAttribute("sheet", carton);
		}
         
            if(((List<Set>) session.getAttribute("sheet")).size()<1){
               String bal="";
        
        Set<String> arCart = new LinkedHashSet<String>();
        do{
            bal="B"+(int) Math.floor(Math.random() * (15 - 1 + 1) + 1);
            arCart.add(bal);
        }while(arCart.size()<5);
        

        do{
            bal="I"+(int) Math.floor(Math.random() * (30 - 16 + 1) + 16);
            arCart.add(bal);
        }while(arCart.size()<10);
        

        do{
            bal="N"+(int) Math.floor(Math.random() * (45 - 31 + 1) + 31);
            arCart.add(bal);
        }while(arCart.size()<14);
        
        do{
            bal="G"+(int) Math.floor(Math.random() * (60 - 46+ + 1) + 46);
            arCart.add(bal);
        }while(arCart.size()<19);

        do{
            bal="O"+(int) Math.floor(Math.random() * (75 - 61+ + 1) + 61);
            arCart.add(bal);
        }while(arCart.size()<24);
            
        
       carton.add(arCart);

            }
       return carton;
           
    }

}
