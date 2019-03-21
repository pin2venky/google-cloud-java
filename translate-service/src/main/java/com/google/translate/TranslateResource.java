package com.google.translate;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TranslateResource {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/")
	public String welcome() {
		return "Hello world";
	}

	@GetMapping("/translate/{encodedText}")
	public String translate(@PathVariable String encodedText) {

		String key = "<Get the Key from Google cloud>";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		String url = "https://www.googleapis.com/language/translate/v2?key=" + key + "&q=" + encodedText + "&target=en";

		return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();

	}

	/*
	 * @GetMapping("translate") public String translate() {
	 * 
	 * Translate translate = TranslateOptions.getDefaultInstance().getService();
	 * 
	 * // The text to translate String text = "Hello, world!";
	 * 
	 * // Translates some text into Russian Translation translation =
	 * translate.translate( text, TranslateOption.sourceLanguage("en"),
	 * TranslateOption.targetLanguage("ru"));
	 * 
	 * 
	 * System.out.printf("Text: %s%n", text); System.out.printf("Translation: %s%n",
	 * translation.getTranslatedText());
	 * 
	 * 
	 * return "text";
	 * 
	 * }
	 */

}
