package com.example.hospital.mybatis.model;

public class AssignedPatients {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ASSIGNEDPATIENTS.PATIENTS_ID
     *
     * @mbg.generated Mon May 08 03:01:08 EEST 2023
     */
    private Long patientsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ASSIGNEDPATIENTS.SPECIALISTS_ID
     *
     * @mbg.generated Mon May 08 03:01:08 EEST 2023
     */
    private Long specialistsId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ASSIGNEDPATIENTS.PATIENTS_ID
     *
     * @return the value of ASSIGNEDPATIENTS.PATIENTS_ID
     *
     * @mbg.generated Mon May 08 03:01:08 EEST 2023
     */
    public Long getPatientsId() {
        return patientsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ASSIGNEDPATIENTS.PATIENTS_ID
     *
     * @param patientsId the value for ASSIGNEDPATIENTS.PATIENTS_ID
     *
     * @mbg.generated Mon May 08 03:01:08 EEST 2023
     */
    public void setPatientsId(Long patientsId) {
        this.patientsId = patientsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ASSIGNEDPATIENTS.SPECIALISTS_ID
     *
     * @return the value of ASSIGNEDPATIENTS.SPECIALISTS_ID
     *
     * @mbg.generated Mon May 08 03:01:08 EEST 2023
     */
    public Long getSpecialistsId() {
        return specialistsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ASSIGNEDPATIENTS.SPECIALISTS_ID
     *
     * @param specialistsId the value for ASSIGNEDPATIENTS.SPECIALISTS_ID
     *
     * @mbg.generated Mon May 08 03:01:08 EEST 2023
     */
    public void setSpecialistsId(Long specialistsId) {
        this.specialistsId = specialistsId;
    }
}