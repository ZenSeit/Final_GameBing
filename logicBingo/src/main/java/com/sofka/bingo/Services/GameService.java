/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sofka.bingo.Services;

import com.sofka.bingo.Dao.GameDao;
import com.sofka.bingo.Models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author diego
 * 
 * Clase GameService que implemente la interfaz IGame para hacer las transacciones con la base de datos
 */
@Service
public class GameService implements IGame {
    
    @Autowired
    private GameDao gamdao;

    
    @Override
    @Transactional
    public void createGame(Game g) {
        gamdao.save(g); 
    }
   
}
