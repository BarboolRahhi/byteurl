package com.rb.smallurl.service;

import com.rb.smallurl.dto.RedirectRequestDto;
import com.rb.smallurl.dto.RedirectResponseDto;
import com.rb.smallurl.entity.Redirect;
import com.rb.smallurl.exception.BadRequestException;
import com.rb.smallurl.exception.NotFoundException;
import com.rb.smallurl.repository.RedirectRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectService {

    @Value("${app.url}")
    private String appUrl;

    private final RedirectRepository redirectRepository;
    private final MapperService mapperService;

    public RedirectService(RedirectRepository redirectRepository, MapperService mapperService) {
        this.redirectRepository = redirectRepository;
        this.mapperService = mapperService;
    }

    public RedirectResponseDto createRedirect(RedirectRequestDto requestDto) throws BadRequestException {

        String alias = requestDto.getAlias().replaceAll(" ", "-");
        requestDto.setAlias(alias);

        if (redirectRepository.existsByAlias(requestDto.getAlias())) {
            throw new BadRequestException("Alias already exists!");
        }

        if (!requestDto.getUrl().startsWith("http")) {
            String url = "http://" + requestDto.getUrl();
            requestDto.setUrl(url);
        }

        Redirect redirect = redirectRepository.save(mapperService.requestDtoToRedirect(requestDto));
        redirect.setAlias(appUrl + redirect.getAlias());

        return (mapperService.redirectToResponseDto(redirect));
    }

    public Redirect getRedirect(String alias) {
        return redirectRepository.findByAlias(alias)
                .orElseThrow(() -> new NotFoundException("Hey, We don't have that alias. Try making one!"));
    }


}
