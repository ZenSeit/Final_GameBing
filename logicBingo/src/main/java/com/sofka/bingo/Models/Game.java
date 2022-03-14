/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sofka.bingo.Models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Diego Fernando Becerra Zambrano
 */

/**
 * Clase juego con sus respectivos parametros de Id, Ganador. fecha de creacion y eliminacion del juego
 */


@Entity
@Table (name = "game")
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_game" )
    private Long Id;
    @Getter @Setter @Column(name = "winner")
    private String winner;
    @Temporal(TemporalType.DATE)
    @Getter @Setter @Column(name = "created_at")
    private Date creat;
    @Getter @Setter @Column(name = "deteled_at")
    private Date delt;
     
}
