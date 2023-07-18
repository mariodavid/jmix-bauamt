package com.rtcab.bauamt.view.antrag;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Span;
import com.rtcab.bauamt.entity.*;

import com.rtcab.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.core.FileRef;
import io.jmix.core.TimeSource;
import io.jmix.data.Sequence;
import io.jmix.data.Sequences;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.component.combobox.JmixComboBox;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.component.validation.ValidationErrors;
import io.jmix.flowui.model.CollectionPropertyContainer;
import io.jmix.flowui.model.DataContext;
import io.jmix.flowui.model.InstancePropertyContainer;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "abweichungs/:id", layout = MainView.class)
@ViewController("Abweichung.detail")
@ViewDescriptor("abweichung-detail-view.xml")
@EditedEntityContainer("antragDc")
public class AbweichungDetailView extends StandardDetailView<Abweichung> {

    @Autowired
    private TimeSource timeSource;
    private Antragsart antragsart;
    @Autowired
    private Sequences sequences;
    @ViewComponent
    private InstancePropertyContainer<Bauherr> bauherrDc;
    @ViewComponent
    private DataContext dataContext;
    @ViewComponent
    private DataGrid<Bauvorlage> bauvorlagenDataGrid;
    @Autowired
    private UiComponents uiComponents;
    @ViewComponent
    private CollectionPropertyContainer<Bauvorlage> bauvorlagenDc;
    @Autowired
    private BauherrGenerator bauherrGenerator;
    @Autowired
    private BauvorlagenFactory bauvorlagenFactory;
    @ViewComponent
    private ComboBox<Abweichungsunterkategorie> unterkategorieField;
    @Autowired
    private DataManager dataManager;

    @Subscribe
    public void onInit(InitEvent event) {

        bauvorlagenDataGrid.addComponentColumn(bauvorlage -> {
                    Checkbox checkbox = uiComponents.create(Checkbox.class);
                    checkbox.setValue(bauvorlage.getPflicht() == null ? false : bauvorlage.getPflicht());
                    checkbox.setReadOnly(true);
                    return checkbox;
                })
                .setAutoWidth(true)
                .setHeader("Pflicht");

        bauvorlagenDataGrid.addComponentColumn(bauvorlage -> {
                    FileRef fileRef = bauvorlage.getDatei();
                    if (fileRef != null) {
                        return new Span(fileRef.getFileName());
                    } else {
                        return new Span("n/a");
                    }
                })
                .setAutoWidth(true)
                .setHeader("Datei");
    }

    @Subscribe
    public void onQueryParametersChange(final QueryParametersChangeEvent event) {
        if (event.getQueryParameters().getParameters().containsKey("antragsart")) {
            antragsart = Antragsart.fromId(event.getQueryParameters().getParameters().get("antragsart").get(0));
        }
    }

    @Subscribe
    public void onInitEntity(final InitEntityEvent<Antrag> event) {
        if (antragsart != null) {
            event.getEntity().setAntragsart(antragsart);
            event.getEntity().setAntragseingang(timeSource.now().toLocalDate());
            event.getEntity().setAktenzeichen("AZ-%05d".formatted(sequences.createNextValue(Sequence.withName(antragsart.getId()))));
            event.getEntity().setStatus(Antragsstatus.ERFASSUNG);
        }
    }

    @Subscribe
    public void onReady(final ReadyEvent event) {
        if (antragsart != null) {
            initBauherr();
            bauvorlagenDc.setItems(bauvorlagenFactory.create(dataContext, antragsart, getEditedEntity()));
        }
    }

    @Subscribe
    public void onValidation(final ValidationEvent event) {
        ValidationErrors errors = checkAllBauvorlagenWithPflichtAreUploaded();
        event.addErrors(errors);
    }

    private ValidationErrors checkAllBauvorlagenWithPflichtAreUploaded() {
        boolean bauvorlageWithoutPflichtUpload = bauvorlagenDc.getDisconnectedItems().stream()
                .anyMatch(bauvorlage -> bauvorlage.getPflicht() && bauvorlage.getDatei() == null);
        return bauvorlageWithoutPflichtUpload ? ValidationErrors.of("Es müssen alle Pflichtbauvorlagen hochgeladen werden.") : ValidationErrors.none();
    }


    private void initBauherr() {
        Bauherr bauherr = dataContext.create(Bauherr.class);
        bauherrGenerator.fill(bauherr);
        bauherr.setAntrag(getEditedEntity());
        getEditedEntity().setBauherr(bauherr);
        bauherrDc.setItem(bauherr);
    }

    @Subscribe("kategorieField")
    public void onKategorieFieldComponentValueChange(final AbstractField.ComponentValueChangeEvent<JmixComboBox<Abweichungskategorie>, Abweichungskategorie> event) {
        if (event.getValue() != null) {
            List<Abweichungsunterkategorie> relatedUnterkategorien = dataManager.load(Abweichungsunterkategorie.class)
                    .all()
                    .list()
                    .stream().filter(unterkategorie -> unterkategorie.getKategorie().equals(event.getValue())).toList();
            unterkategorieField.setItems(relatedUnterkategorien);
        }
    }
}
