package org.mwashi_mwale.authenticator.data.dto;

import java.util.List;

public record PaginatedResult<T>(List<T> data, Long count) {
}
