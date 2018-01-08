/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.annaczeczek.millionaires.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.Arrays;
import java.util.List;


@SpringUI
@Theme("valo")
public class MainUi extends UI {

    private static final String URL = "http://aniacz.pl:3000/dashboard-solo/db/millionaires?refresh=1m&panelId=6&orgId=1&tab=general&theme=light&from=%s&to=now&var-currency=%s&var-cryptoCurrency=%s";
    private BrowserFrame currencyGraph = new BrowserFrame("",
            new ExternalResource(String.format(URL, "now-1h", "USD", "BTC")));

    private List<String> currencies = Arrays.asList("PLN", "USD");
    private List<String> cryptoCurrencies = Arrays.asList("BTC", "BCC", "LTC");
    private List<String> timeRange = Arrays.asList("now-1h", "now-6h", "now-24h", "now-2d", "now-7h");

    private String selectedCurrency = currencies.get(0);
    private String selectedCryptoCurrency = cryptoCurrencies.get(0);
    private String selectedTime = timeRange.get(0);

    @Override
    protected void init(VaadinRequest request) {
        Layout layout = new VerticalLayout();
        layout.addComponent(createSelectLayout());
        currencyGraph.setWidth("100%");
        currencyGraph.setHeight("400px");
        layout.addComponent(currencyGraph);
        setContent(layout);
    }

    private void resetUrl() {
        this.currencyGraph.setSource(new ExternalResource(String.format(URL, this.selectedTime, this.selectedCurrency, this.selectedCryptoCurrency)));
    }

    private Layout createSelectLayout() {
        Layout layout = new HorizontalLayout();

        NativeSelect<String> currencySelect = new NativeSelect<>("Currency", currencies);
        currencySelect.setEmptySelectionAllowed(false);
        currencySelect.addValueChangeListener(event -> {
            this.selectedCurrency = event.getValue();
            resetUrl();
        });
        currencySelect.setSelectedItem(currencies.get(0));

        NativeSelect<String> cryptoCurrencySelect = new NativeSelect<>("Crypto currency", cryptoCurrencies);
        cryptoCurrencySelect.setEmptySelectionAllowed(false);
        cryptoCurrencySelect.addValueChangeListener(event -> {
            this.selectedCryptoCurrency = event.getValue();
            resetUrl();
        });
        cryptoCurrencySelect.setSelectedItem(cryptoCurrencies.get(0));

        NativeSelect<String> timeSelect = new NativeSelect<>("Time range", timeRange);
        timeSelect.setEmptySelectionAllowed(false);
        timeSelect.addValueChangeListener(event -> {
            this.selectedTime = event.getValue();
            resetUrl();
        });
        timeSelect.setSelectedItem(timeRange.get(0));

        layout.addComponent(currencySelect);
        layout.addComponent(cryptoCurrencySelect);
        layout.addComponent(timeSelect);
        return layout;
    }
}