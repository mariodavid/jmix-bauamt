package de.bunge.bauamt.view.entwurfsverfasser;

import de.bunge.bauamt.entity.Entwurfsverfasser;

import de.bunge.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "entwurfsverfassers/:id", layout = MainView.class)
@ViewController("Entwurfsverfasser.detail")
@ViewDescriptor("entwurfsverfasser-detail-view.xml")
@EditedEntityContainer("entwurfsverfasserDc")
public class EntwurfsverfasserDetailView extends StandardDetailView<Entwurfsverfasser> {
}
