package com.example.hospital.mybatis.dao;

import com.example.hospital.mybatis.model.Specialist;
import com.example.hospital.mybatis.model.SpecialistExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpecialistMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SPECIALIST
     *
     * @mbg.generated Mon May 08 00:48:13 EEST 2023
     */
    long countByExample(SpecialistExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SPECIALIST
     *
     * @mbg.generated Mon May 08 00:48:13 EEST 2023
     */
    int deleteByExample(SpecialistExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SPECIALIST
     *
     * @mbg.generated Mon May 08 00:48:13 EEST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SPECIALIST
     *
     * @mbg.generated Mon May 08 00:48:13 EEST 2023
     */
    int insert(Specialist row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SPECIALIST
     *
     * @mbg.generated Mon May 08 00:48:13 EEST 2023
     */
    int insertSelective(Specialist row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SPECIALIST
     *
     * @mbg.generated Mon May 08 00:48:13 EEST 2023
     */
    List<Specialist> selectByExample(SpecialistExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SPECIALIST
     *
     * @mbg.generated Mon May 08 00:48:13 EEST 2023
     */
    Specialist selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SPECIALIST
     *
     * @mbg.generated Mon May 08 00:48:13 EEST 2023
     */
    int updateByExampleSelective(@Param("row") Specialist row, @Param("example") SpecialistExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SPECIALIST
     *
     * @mbg.generated Mon May 08 00:48:13 EEST 2023
     */
    int updateByExample(@Param("row") Specialist row, @Param("example") SpecialistExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SPECIALIST
     *
     * @mbg.generated Mon May 08 00:48:13 EEST 2023
     */
    int updateByPrimaryKeySelective(Specialist row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SPECIALIST
     *
     * @mbg.generated Mon May 08 00:48:13 EEST 2023
     */
    int updateByPrimaryKey(Specialist row);
}