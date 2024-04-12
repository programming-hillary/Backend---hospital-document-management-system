/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mwashi_mwale.authenticator.endpoints;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/me")
public class LoginEndpoint {

    @GetMapping("")
    public Mono<Map<String, Object>> current(@AuthenticationPrincipal Mono<Principal> principal) {
        return principal
                .map(person ->
                        Map.of(
                                "name", person.getName(),
                                "roles", AuthorityUtils.authorityListToSet(((Authentication) person)
                                        .getAuthorities())
                        )
                );
    }

}
