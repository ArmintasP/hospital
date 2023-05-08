package com.example.hospital.usecases;

import com.example.hospital.entities.Specialist;
import com.example.hospital.entities.common.Speciality;
import com.example.hospital.interceptors.LoggedInvocation;
import com.example.hospital.services.ReasonValidation;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.Conversation;
import jakarta.enterprise.context.ConversationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@ConversationScoped
@Named
public class ValidateReason implements Serializable {
    @Inject
    ReasonValidation reasonValidation;

    @Inject
    private Conversation conversation;

    @Getter
    private boolean isValid = false;

    @Getter
    @Setter
    private String reason = "";

    @LoggedInvocation
    public String runValidation(Specialist specialist){
        if (!reasonValidation.isValidReason(reason, specialist.getSpeciality()))
            return "";

        isValid = true;
        conversation.begin();
        return "specialist?faces-redirect=true&amp;specialistId=" + specialist.getId().toString();
    }

    @LoggedInvocation
    public void endConversation(){
        conversation.end();
    }
}
