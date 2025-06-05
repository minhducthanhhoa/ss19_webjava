package com.data.sesson19_webjava.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên phim không được để trống")
    private String title;

    @NotBlank(message = "Đạo diễn không được để trống")
    private String director;

    @Min(value = 1900, message = "Năm phát hành không hợp lệ")
    @Max(value = 2025, message = "Năm phát hành không hợp lệ")
    private Integer releaseYear;

    private String genre;

    @Min(value = 1, message = "Thời lượng phải lớn hơn 0")
    private Integer duration;

    private String language;

    @Pattern(regexp = "^(http|https)://.*$", message = "URL poster không hợp lệ")
    private String poster;

    private boolean status;

}
