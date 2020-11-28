package com.rb.smallurl.service;

import com.rb.smallurl.dto.RedirectRequestDto;
import com.rb.smallurl.dto.RedirectResponseDto;
import com.rb.smallurl.entity.Redirect;
import org.springframework.stereotype.Component;

@Component
public class MapperService {

    public RedirectResponseDto redirectToResponseDto(Redirect redirect) {
        return new RedirectResponseDto(redirect.getAlias(), redirect.getUrl(), redirect.getCreatedAt());
    }

    public Redirect requestDtoToRedirect(RedirectRequestDto requestDto) {
        return  new Redirect(requestDto.getAlias(), requestDto.getUrl());
    }
}
