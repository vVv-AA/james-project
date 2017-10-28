package org.apache.james.mailbox.store.probe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SieveProbeTest {

    @Test
    public void sanitizeFilenameShouldNotChangeInputWhenSivExtension() {
        String validScriptFileNameSiv = "myscript.siv";
        assertThat(SieveProbe.sanitizeScriptName(validScriptFileNameSiv)).isEqualTo(validScriptFileNameSiv);
    }

    @Test
    public void sanitizeFilenameShouldNotChangeInputWhenSieveExtension() {
        String validScriptFileNameSieve = "myscript.sieve";
        assertThat(SieveProbe.sanitizeScriptName(validScriptFileNameSieve)).isEqualTo(validScriptFileNameSieve);
    }

    @Test
    public void sanitizeFilenameShouldAppendDotSieveWhenInputIsInvalid() {
        String validScriptFileName = "myscript.txt";
        assertThat(SieveProbe.sanitizeScriptName(validScriptFileName)).isEqualTo(validScriptFileName + ".sieve");
    }

}
