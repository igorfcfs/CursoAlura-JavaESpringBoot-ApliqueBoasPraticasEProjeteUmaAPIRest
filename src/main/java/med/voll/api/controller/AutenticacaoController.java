package med.voll.api.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.*;
import med.voll.api.domain.usuario.DadosAutenticacao;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager auth;
	
	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
		var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var authentication = auth.authenticate(token);
		return ResponseEntity.ok().build();
	}
}
