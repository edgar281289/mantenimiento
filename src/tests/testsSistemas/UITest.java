package tests.testsSistemas;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;

import agenda.vista.AgendaFrame;

public abstract class UITest {

	protected FrameFixture frame;
	protected abstract JFrame intAppContext();

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() {
		
		frame = new FrameFixture(GuiActionRunner.execute(new GuiQuery<JFrame>() {
			protected JFrame executeInEDT() {
				return new AgendaFrame();
			}
		}));
		
		frame.show();
		
		frame.robot.settings().delayBetweenEvents(500);
		frame.textBox("tfNombre").requireText("");
		frame.textBox("tfApellido").requireText("");
		frame.textBox("tfTelefono").requireText("");
		frame.textBox("tfEmail").requireText("");
		
		GenericTypeMatcher<JTextArea> matcher= new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			
			@Override
			protected boolean isMatching(JTextArea component) {
				return true;
			}
			
		};

		frame.textBox(matcher).requireNotEditable();
		frame.textBox(matcher).requireEmpty();
	}

	@After
	public void tearDown() {
		frame.cleanUp();
	}
}