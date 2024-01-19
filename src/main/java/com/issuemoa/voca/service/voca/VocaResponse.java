package com.issuemoa.voca.service.voca;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="Voca Response")
public record VocaResponse(
        @Schema(description = "IDX") Long id,
        @Schema(description = "단어") String word,
        @Schema(description = "의미") String mean) {
}
