package de.bunge.bauamt.view.antrag;

import com.vaadin.flow.router.QueryParameters;
import de.bunge.bauamt.entity.Antrag;

import de.bunge.bauamt.entity.Antragsart;
import de.bunge.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.core.Metadata;
import io.jmix.core.TimeSource;
import io.jmix.flowui.Dialogs;
import io.jmix.flowui.ViewNavigators;
import io.jmix.flowui.app.inputdialog.DialogActions;
import io.jmix.flowui.app.inputdialog.DialogOutcome;
import io.jmix.flowui.app.inputdialog.InputParameter;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "antrags", layout = MainView.class)
@ViewController("Antrag.list")
@ViewDescriptor("antrag-list-view.xml")
@LookupComponent("antragsDataGrid")
@DialogMode(width = "64em")
public class AntragListView extends StandardListView<Antrag> {
    @Autowired
    private Dialogs dialogs;
    @Autowired
    private Metadata metadata;
    @Autowired
    private TimeSource timeSource;
    @Autowired
    private ViewNavigators viewNavigators;

    @Subscribe("antragsDataGrid.create")
    public void onAntragsDataGridCreate(final ActionPerformedEvent event) {
        dialogs.createInputDialog(this)
                .withHeader("Antrag erstellen")
                .withParameters(InputParameter.enumParameter("antragsart", Antragsart.class)
                        .withLabel("Antragsart")
                        .withRequired(true)
                        .withDefaultValue(Antragsart.BAUANTRAG))
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        Antragsart antragsart = closeEvent.getValue("antragsart");


                        Class<? extends Antrag> antragClass = antragsart.getAntragClass();
                        viewNavigators.detailView(antragClass)
                                .newEntity()
                                .withQueryParameters(QueryParameters.of("antragsart", antragsart.getId()))
                                .navigate();
                    }
                }).open();
    }
}
