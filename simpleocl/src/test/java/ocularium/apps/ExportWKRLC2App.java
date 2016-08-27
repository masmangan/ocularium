package ocularium.apps;

import java.io.FileWriter;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.model.IModel;
import com.change_vision.jude.api.inf.project.ProjectAccessor;

import ocularium.OculariumFacade;

/**
 * Simple exploratory test application to checkout export results from W&K R&L, Second Edition, Chapter 2.
 * @author marco.mangan@pucrs.br
 *
 */
public class ExportWKRLC2App {
	private static final String WK_C2_FILE = "/Users/marco/dvlp-2016-2/ocularium/specs/royalloyal/mangan-warmer-kleppe-royal-loyal-chapter-2.asta";

	public static void main(String[] args) throws Exception {
		

		System.out.println("Opening project...");

		ProjectAccessor prjAccessor = AstahAPI.getAstahAPI().getProjectAccessor();
		prjAccessor.open(WK_C2_FILE, true, false, true);
		
		System.out.println("Creating file...");
		FileWriter fw = new FileWriter(OculariumFacade.getOclProjectPath(prjAccessor));
        System.out.println(prjAccessor.getProjectPath());

		IModel project = prjAccessor.getProject();
		System.out.println("Running facade...");

		OculariumFacade f = new OculariumFacade(project);
		System.out.println("Exporting constraints...");
		
		f.exportOCL(fw);
		prjAccessor.close();
		fw.close();
		System.out.println("Done.");


	}



}