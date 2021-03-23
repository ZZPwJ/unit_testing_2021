package pl.lodz.p.zzpj.testing.assertj;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.lodz.p.zzpj.testing.assertj.FellowTestFixture.frodo;
import static pl.lodz.p.zzpj.testing.assertj.FellowTestFixture.sauron;

public class FellowshipAssertionTest {

    private Fellowship fellowship = formTheFellowshipOfTheRing();

    @Test
    public void frodoShouldBeIn() {

    }

    @Test
    public void sauronShouldNotBeIn() {

    }

    @Test
    public void shouldFrodoNameBeCorrectAndNotBeASauronAndBeInFellowship() {

    }

    @Test
    public void aragornShouldBeBeforeBoromir() {
    }

    @Test
    public void shouldNotContainDuplicatedFellows() {
    }

    @Test
    public void shouldContainOnlyFellowsWithExpectedNamesInProperOrder() {
    }

    @Test
    public void shouldContainNineFellowsButNoneGiant() {
    }

    @Test
    public void shouldContainTupleForBoromirSamAndLegolas() {
        // Extracting multiple values at once (using tuple to group them)
        // Create tuples with name and race name
    }


    @Test
    public void shouldContainsFourHobbits() {

    }


    private Fellowship formTheFellowshipOfTheRing() {
        return new Fellowship(
                frodo(),
                FellowTestFixture.sam(),
                FellowTestFixture.merry(),
                FellowTestFixture.pippin(),
                FellowTestFixture.gandalf(),
                FellowTestFixture.legolas(),
                FellowTestFixture.gimli(),
                FellowTestFixture.aragorn(),
                FellowTestFixture.boromir());
    }
}
