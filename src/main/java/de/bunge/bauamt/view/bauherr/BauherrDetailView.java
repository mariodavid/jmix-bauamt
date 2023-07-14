package de.bunge.bauamt.view.bauherr;

import de.bunge.bauamt.entity.Bauherr;

import de.bunge.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "bauherren/:id", layout = MainView.class)
@ViewController("Bauherr.detail")
@ViewDescriptor("bauherr-detail-view.xml")
@EditedEntityContainer("bauherrDc")
public class BauherrDetailView extends StandardDetailView<Bauherr> {
}
