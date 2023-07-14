package de.bunge.bauamt.view.antrag;

import de.bunge.bauamt.entity.Antrag;

import de.bunge.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "antrags", layout = MainView.class)
@ViewController("Antrag.list")
@ViewDescriptor("antrag-list-view.xml")
@LookupComponent("antragsDataGrid")
@DialogMode(width = "64em")
public class AntragListView extends StandardListView<Antrag> {
}
