package com.data.sesson19_webjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "theater")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên rạp không được để trống")
    @Column(name = "theater_name", nullable = false)
    private String theaterName;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Column(nullable = false)
    private String address;

    @Min(value = 1, message = "Số phòng chiếu phải lớn hơn 0")
    @Column(name = "number_screen_room", nullable = false)
    private Integer numberScreenRoom;

    @Column
    private boolean status = true;
}
