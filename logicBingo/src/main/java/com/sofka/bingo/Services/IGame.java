/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sofka.bingo.Services;

import com.sofka.bingo.Models.Game;

/**
 *
 * @author diego
 * 
 * Se crea esta interfaz con el fin de asegurar que exista la implementacion del metodo createGame
 */
public interface IGame {
    
    public void createGame(Game g);
    
}
