/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
*/
package sdmx.data;

import sdmx.Registry;
import sdmx.data.flat.FlatDataSetWriter;
import sdmx.data.structured.StructuredDataWriter;
import sdmx.footer.FooterType;
import sdmx.message.BaseHeaderType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.version.common.ParseDataCallbackHandler;

/**
 *
 * @author James
 */
public class FlatParseDataCallbackHandler implements ParseDataCallbackHandler{

    @Override
    public void setNamespace(String prefix, String namespace) {
    }

    @Override
    public void headerParsed(BaseHeaderType header) {
    }

    @Override
    public void footerParsed(FooterType footer) {
    }

    @Override
    public DataSetWriter getDataSetWriter() {
        return new FlatDataSetWriter();
    }

    @Override
    public void documentFinished() {
    }

    @Override
    public String getDimensionAtObservationHint() {
        return null;
    }

    @Override
    public void setDimensionAtObservationHint(String s) {
    }

    @Override
    public Registry getRegistry() {
        return null;
    }

    @Override
    public void setRegistry(Registry reg) {
    }
    
}
