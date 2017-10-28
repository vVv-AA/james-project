package org.apache.james.sieverepository.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SieveRepositoryManagementMBeanTest {

    @Test
    public void sanitizeFilenameShouldNotChangeInputWhenSivExtension() {
        String validScriptFileNameSiv = "myscript.siv";
        assertThat(SieveRepositoryManagementMBean.sanitizeScriptName(validScriptFileNameSiv)).isEqualTo(validScriptFileNameSiv);
    }

    @Test
    public void sanitizeFilenameShouldNotChangeInputWhenSieveExtension() {
        String validScriptFileNameSieve = "myscript.sieve";
        assertThat(SieveRepositoryManagementMBean.sanitizeScriptName(validScriptFileNameSieve)).isEqualTo(validScriptFileNameSieve);
    }

    @Test
    public void sanitizeFilenameShouldAppendDotSieveWhenInputIsInvalid() {
        String validScriptFileName = "myscript.txt";
        assertThat(SieveRepositoryManagementMBean.sanitizeScriptName(validScriptFileName)).isEqualTo(validScriptFileName + ".sieve");
    }

}
