package com.footsy.demo.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean estadoActivo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    @Column (nullable = false, unique = true)
    private String codigo;
    private String nombre;
    private String descripcion;
    private Double precioUnitario;
    private Double precioVenta;
    @Enumerated(EnumType.STRING)
    private InfoTallas infoTallas;
    private String peso;
    private String dimensiones;
    private String urlImagen;



}
