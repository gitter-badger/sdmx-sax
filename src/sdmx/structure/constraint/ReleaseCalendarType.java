/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.constraint;

/**
 *	<xs:complexType name="ReleaseCalendarType">
		<xs:annotation>
			<xs:documentation>ReleaseCalendarType describes information about the timing of releases of the constrained data. All of these values use the standard "P7D" - style format.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="Periodicity" type="xs:string">
				<xs:annotation>
					<xs:documentation>Periodicity is the period between releases of the data set.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="Offset" type="xs:string">
				<xs:annotation>
					<xs:documentation>Offset is the interval between January first and the first release of data within the year.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="Tolerance" type="xs:string">
				<xs:annotation>
					<xs:documentation>Tolerance is the period after which the release of data may be deemed late.</xs:documentation>
				</xs:annotation>
			</xs:element>
		</xs:sequence>
	</xs:complexType>

 * @author James
 */
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class ReleaseCalendarType {
    private String periodicity = "";
    private String offset = "";
    private String tolerance = "";

    /**
     * @return the periodicity
     */
    public String getPeriodicity() {
        return periodicity;
    }

    /**
     * @param periodicity the periodicity to set
     */
    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    /**
     * @return the offset
     */
    public String getOffset() {
        return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(String offset) {
        this.offset = offset;
    }

    /**
     * @return the tolerance
     */
    public String getTolerance() {
        return tolerance;
    }

    /**
     * @param tolerance the tolerance to set
     */
    public void setTolerance(String tolerance) {
        this.tolerance = tolerance;
    }
    
}
