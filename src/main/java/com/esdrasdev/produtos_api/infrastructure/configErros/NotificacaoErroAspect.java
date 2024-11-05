package com.esdrasdev.produtos_api.infrastructure.configErros;

import com.esdrasdev.produtos_api.business.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class NotificacaoErroAspect {

    private final EmailService emailService;

    @Pointcut("@within(com.javanautas.fakeapius.infrastructure.configs.error.NotificacaoErro) || @annotation(com.javanautas.fakeapius.infrastructure.configs.error.NotificacaoErro)")
    public void notificacaoErroPointCut() {}

    @AfterThrowing(pointcut = "notificacaoErroPointCut()", throwing = "e")
    public void notificacaoErro(final Exception e){
        emailService.enviaEmailExcecao(e);
    }

}
