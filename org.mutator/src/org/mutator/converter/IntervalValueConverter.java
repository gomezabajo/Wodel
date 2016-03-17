package org.mutator.converter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.conversion.ValueConverter;

public class IntervalValueConverter extends DefaultTerminalConverters {
	@ValueConverter(rule = "MaxCardinality")
    public IValueConverter<Integer> MaxCardinality() {
        return new IValueConverter<Integer>() {
            public Integer toValue(String string, INode node) {
                if (Strings.isEmpty(string))
                    throw new ValueConverterException("Couldn't convert empty string to int", node, null);
                else if ("*".equals(string.trim()))
                    return -1;
                try {
                    return Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    throw new ValueConverterException("Couldn't convert '"+string+"' to int", node, e);
                }
            }

            public String toString(Integer value) {
                return ((value == -1) ? "*" : Integer.toString(value));
            }
        };	
	}		
}
