package com.bridgelabz.lms.model;


import com.bridgelabz.lms.dto.QualificationDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "qualification_info")
@Data
public class QualificationInfo {

//    @Transient
//    public static final String SEQUENCE_NAME = "qualification_sequence";
//
//    @Id
//    private long id;

    private String collageName;
    private String degree;
    private String percentage;
    private String yearOfPassing;
    private String course;
    private String document;

    public QualificationInfo() {
        super();
    }

    public QualificationInfo(QualificationDTO qualificationDto) {
        this.collageName = qualificationDto.getCollageName();
        this.degree = qualificationDto.getDegree();
        this.percentage = qualificationDto.getPercentage();
        this.yearOfPassing = qualificationDto.getYearOfPassing();
        this.course = qualificationDto.getCourse();
        this.document = qualificationDto.getDocument();
    }

}

