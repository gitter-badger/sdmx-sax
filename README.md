sdmx-sax
========

Sdmx Sax Parser

This is a non-validating sdmx parser... it does not validate the sdmx file at all...
it aims to abstract older version of sdmx into an sdmx 2.1 data model...

there are wrappers to access ABS, OECD, ECB, ESTAT data sets...
the first place to start is to run the swingdemo...
you can download a packaged version from sourceforge
http://sourceforge.net/projects/sdmx-sax/
or checkout the netbeans project and build from source.. (requires sdmx-sax project too!)

you can play around with the sdmx interface with the swingdemo.. it shows very basic tabular data as returned from the
sdmx service...

when using sdmx-sax inside your program you can use SdmxIO.parseStructure(InputStream in, Registry registry)
to obtain a StructureType reference... 
or SdmxIO.parseData(InputStream in)
to obtain a DataMessage reference

A registry is used to look up structural information.. the interface is very early on in development.. this can be queried for structural information, or sometimes queried for 
data as well...

main implementations of registry are;
StructureType : yes a structure message is a registry ot structural information this can't be queried for data
LocalRegistry : a convenience class that loads lots of StructureType messages and queries them one after the other for Structural Information
sdmx.version.twopointzero.Sdmx20SDWSOAPQueryable   -> this represents the sdmx data service.. don't forget to set the required namespace for soap messages
as well as the url of the data service, look into the SwingDemo class 'DataProvider' for details of supported data services. This can be queried for data.
RESTServiceRegistry : this represents an sdmx 2.1 data service, and can be queried for data and structure...
there are lots of caveats on the supported dataquery message as I have only just added support for querying data...
1. DataQueryWhere must have an enclosing <And>
2. Wheres must be structured like they are in the Swingdemo, look in SwingDemo -> ConceptChoiceModel->toDataQuery
   for an example of the DataWhere being constructed...
   <DataQueryWhere>
       <And>
       <DataSetID>8nrpver5</DataSetID>
       <Or>
          <DimensionValue id="dima">a</DimensionWhere>
          <DimensionValue id="dima">b</DimensionWhere>
       </Or>
       <Or>
          <DimensionValue id="dimb">a</DimensionWhere>
          <DimensionValue id="dimb">b</DimensionWhere>
       </Or>
       </And>
   </DataQueryWhere>
For all values for a dimension, simply dont specify the dimension at all, and everything will be returned!

as a convenience, you can 'wrap' a data message with some structure to make a useful data model
StructureDataMessage structured = new StructureDataMessage(dataMessage,registry)
structured.getStructuredDataSet(0);


