package org.hisp.dhis.trackedentity;

/*
 * Copyright (c) 2004-2017, University of Oslo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.hisp.dhis.common.BaseIdentifiableObject;
import org.hisp.dhis.common.DxfNamespaces;
import org.hisp.dhis.common.EmbeddedObject;
import org.hisp.dhis.common.ValueType;
import org.hisp.dhis.trackedentity.TrackedEntityAttribute;

/**
 * @author Abyot Asalefew Gizaw <abyota@gmail.com>
 *
 */
@JacksonXmlRootElement( localName = "trackedEntityTypeAttribute", namespace = DxfNamespaces.DXF_2_0 )
public class TrackedEntityTypeAttribute
    extends BaseIdentifiableObject implements EmbeddedObject
{
    private TrackedEntityType trackedEntityType;

    private TrackedEntityAttribute attribute;

    private boolean displayInList;

    private Integer sortOrder;

    private Boolean mandatory;

    private Boolean allowFutureDate;

    private Boolean renderOptionsAsRadio = false;
    
    private Boolean searchable = false;

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    public TrackedEntityTypeAttribute()
    {
        setAutoFields();
    }

    public TrackedEntityTypeAttribute( TrackedEntityType trackedEntityType, TrackedEntityAttribute attribute )
    {
        this();
        this.trackedEntityType = trackedEntityType;
        this.attribute = attribute;
    }

    public TrackedEntityTypeAttribute( TrackedEntityType trackedEntityType, TrackedEntityAttribute attribute, boolean displayInList,
        Boolean mandatory )
    {
        this( trackedEntityType, attribute );
        this.displayInList = displayInList;
        this.mandatory = mandatory;
    }

    public TrackedEntityTypeAttribute( TrackedEntityType trackedEntityType, TrackedEntityAttribute attribute, boolean displayInList,
        Boolean mandatory, Integer sortOrder )
    {
        this( trackedEntityType, attribute );
        this.displayInList = displayInList;
        this.mandatory = mandatory;
        this.sortOrder = sortOrder;
    }

    public TrackedEntityTypeAttribute( TrackedEntityType trackedEntityType, TrackedEntityAttribute attribute, boolean displayInList,
        Boolean mandatory, Boolean allowFutureDate )
    {
        this( trackedEntityType, attribute, displayInList, mandatory );
        this.allowFutureDate = allowFutureDate;
    }
    

    @Override
    public String getName()
    {
        return (trackedEntityType != null ? trackedEntityType.getDisplayName() + " " : "") + (attribute != null ? attribute.getDisplayName() : "");
    }

    @JsonProperty
    public String getDisplayShortName()
    {
        return (trackedEntityType != null ? trackedEntityType.getDisplayShortName() + " " : "") + (attribute != null ? attribute.getDisplayShortName() : "");
    }

    @JsonProperty
    @JacksonXmlProperty( namespace = DxfNamespaces.DXF_2_0 )
    public ValueType getValueType()
    {
        return attribute != null ? attribute.getValueType() : null;
    }

    @Override
    public String toString()
    {
        return "{" +
            "\"class\":\"" + getClass() + "\", " +
            "\"id\":\"" + id + "\", " +
            "\"uid\":\"" + uid + "\", " +
            "\"trackedEntityType\":" + trackedEntityType + ", " +
            "\"attribute\":" + attribute + ", " +
            "\"created\":\"" + created + "\", " +
            "\"lastUpdated\":\"" + lastUpdated + "\" " +
            "}";
    }

    // -------------------------------------------------------------------------
    // Getters && Setters
    // -------------------------------------------------------------------------

    @JsonProperty
    @JsonSerialize( as = BaseIdentifiableObject.class )
    @JacksonXmlProperty( namespace = DxfNamespaces.DXF_2_0 )
    public TrackedEntityType getTrackedEntityType()
    {
        return trackedEntityType;
    }

    public void setTrackedEntityType( TrackedEntityType trackedEntityType )
    {
        this.trackedEntityType = trackedEntityType;
    }

    @JsonProperty
    @JsonSerialize( as = BaseIdentifiableObject.class )
    @JacksonXmlProperty( namespace = DxfNamespaces.DXF_2_0 )
    public TrackedEntityAttribute getAttribute()
    {
        return attribute;
    }

    public void setAttribute( TrackedEntityAttribute attribute )
    {
        this.attribute = attribute;
    }

    @JsonProperty
    @JacksonXmlProperty( namespace = DxfNamespaces.DXF_2_0 )
    public Boolean isMandatory()
    {
        return mandatory;
    }

    public void setMandatory( Boolean mandatory )
    {
        this.mandatory = mandatory;
    }

    @JsonProperty
    @JacksonXmlProperty( localName = "displayInList", namespace = DxfNamespaces.DXF_2_0 )
    public boolean isDisplayInList()
    {
        return displayInList;
    }

    public void setDisplayInList( boolean displayInList )
    {
        this.displayInList = displayInList;
    }

    @JsonProperty
    @JacksonXmlProperty( namespace = DxfNamespaces.DXF_2_0 )
    public Boolean getAllowFutureDate()
    {
        return allowFutureDate;
    }

    public void setAllowFutureDate( Boolean allowFutureDate )
    {
        this.allowFutureDate = allowFutureDate;
    }

    @JsonProperty
    @JacksonXmlProperty( namespace = DxfNamespaces.DXF_2_0 )
    public Integer getSortOrder()
    {
        return sortOrder;
    }

    public void setSortOrder( Integer sortOrder )
    {
        this.sortOrder = sortOrder;
    }

    @JsonProperty
    @JacksonXmlProperty( namespace = DxfNamespaces.DXF_2_0 )
    public Boolean getRenderOptionsAsRadio()
    {
        return renderOptionsAsRadio;
    }

    public void setRenderOptionsAsRadio( Boolean renderOptionsAsRadio )
    {
        this.renderOptionsAsRadio = renderOptionsAsRadio;
    }

    @JsonProperty
    @JacksonXmlProperty( namespace = DxfNamespaces.DXF_2_0 )
    public Boolean isSearchable()
    {
        return searchable;
    }

    public void setSearchable( Boolean searchable )
    {
        this.searchable = searchable;
    }    
}
