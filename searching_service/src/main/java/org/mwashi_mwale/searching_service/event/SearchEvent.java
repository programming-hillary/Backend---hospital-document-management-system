package org.mwashi_mwale.searching_service.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;


@Getter
@Setter
public class SearchEvent extends ApplicationEvent {
    private String searchItem;

    public SearchEvent(Object source, String searchItem) {
        super(source);
        this.searchItem = searchItem;
    }

    public SearchEvent(String searchItem) {
        super(searchItem);
        this.searchItem = searchItem;
    }
}
