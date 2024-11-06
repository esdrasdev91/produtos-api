package com.esdrasdev.produtos_api.infrastructure.configErros;

import com.esdrasdev.produtos_api.business.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class NotificacaoErroAspect {

    private final EmailService emailService;

    @Pointcut("@within(com.esdrasdev.produtos_api.infrastructure.configErros.NotificacaoErro) || @annotation(com.esdrasdev.produtos_api.infrastructure.configErros.NotificacaoErro)")
    public void notificacaoErroPointCut() {}

    @AfterThrowing(pointcut = "notificacaoErroPointCut()", throwing = "e")
    public void notificacaoErro(final Exception e){
        emailService.enviaEmailExcecao(e);
    }

}
