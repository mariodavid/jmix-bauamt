package de.bunge.bauamt.view.antrag;

import de.bunge.bauamt.entity.Antrag;

import de.bunge.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "antraege/:id", layout = MainView.class)
@ViewController("Antrag.detail")
@ViewDescriptor("antrag-detail-view.xml")
@EditedEntityContainer("antragDc")
public class AntragDetailView extends StandardDetailView<Antrag> {
}
