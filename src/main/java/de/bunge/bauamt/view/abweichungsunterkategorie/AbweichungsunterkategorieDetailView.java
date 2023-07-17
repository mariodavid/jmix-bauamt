package de.bunge.bauamt.view.abweichungsunterkategorie;

import de.bunge.bauamt.entity.Abweichungsunterkategorie;

import de.bunge.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "abweichungsunterkategories/:id", layout = MainView.class)
@ViewController("Abweichungsunterkategorie.detail")
@ViewDescriptor("abweichungsunterkategorie-detail-view.xml")
@EditedEntityContainer("abweichungsunterkategorieDc")
public class AbweichungsunterkategorieDetailView extends StandardDetailView<Abweichungsunterkategorie> {
}
