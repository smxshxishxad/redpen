package cc.redpen.util;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import static org.apache.commons.lang3.StringUtils.repeat;

public class IndentingXMLStreamWriter implements XMLStreamWriter {
  XMLStreamWriter delegate;
  int level;

  public IndentingXMLStreamWriter(XMLStreamWriter delegate) {
    this.delegate = delegate;
  }

  private void writeIndent() throws XMLStreamException {
    delegate.writeCharacters("\n" + repeat("\t", level));
  }

  @Override public void writeEmptyElement(String localName) throws XMLStreamException {
    if (level > 0) writeIndent();
    delegate.writeEmptyElement(localName);
  }

  @Override public void writeStartElement(String localName) throws XMLStreamException {
    if (level > 0) writeIndent();
    delegate.writeStartElement(localName);
    level++;
  }

  @Override public void writeEndElement() throws XMLStreamException {
    level--;
    writeIndent();
    delegate.writeEndElement();
  }

  // delegated methods

  @Override public void close() throws XMLStreamException {
    delegate.close();
  }

  @Override public void flush() throws XMLStreamException {
    delegate.flush();
  }

  @Override public NamespaceContext getNamespaceContext() {
    return delegate.getNamespaceContext();
  }

  @Override public String getPrefix(String uri) throws XMLStreamException {
    return delegate.getPrefix(uri);
  }

  @Override public Object getProperty(String name) throws IllegalArgumentException {
    return delegate.getProperty(name);
  }

  @Override public void setDefaultNamespace(String uri) throws XMLStreamException {
    delegate.setDefaultNamespace(uri);
  }

  @Override public void setNamespaceContext(NamespaceContext context) throws XMLStreamException {
    delegate.setNamespaceContext(context);
  }

  @Override public void setPrefix(String prefix, String uri) throws XMLStreamException {
    delegate.setPrefix(prefix, uri);
  }

  @Override public void writeAttribute(String localName, String value) throws XMLStreamException {
    delegate.writeAttribute(localName, value);
  }

  @Override public void writeAttribute(String namespaceURI, String localName, String value) throws XMLStreamException {
    delegate.writeAttribute(namespaceURI, localName, value);
  }

  @Override
  public void writeAttribute(String prefix, String namespaceURI, String localName, String value) throws XMLStreamException {
    delegate.writeAttribute(prefix, namespaceURI, localName, value);
  }

  @Override public void writeCData(String data) throws XMLStreamException {
    delegate.writeCData(data);
  }

  @Override public void writeCharacters(char[] text, int start, int len) throws XMLStreamException {
    delegate.writeCharacters(text, start, len);
  }

  @Override public void writeCharacters(String text) throws XMLStreamException {
    delegate.writeCharacters(text);
  }

  @Override public void writeComment(String data) throws XMLStreamException {
    delegate.writeComment(data);
  }

  @Override public void writeDefaultNamespace(String namespaceURI) throws XMLStreamException {
    delegate.writeDefaultNamespace(namespaceURI);
  }

  @Override public void writeDTD(String dtd) throws XMLStreamException {
    delegate.writeDTD(dtd);
  }

  @Override public void writeEmptyElement(String namespaceURI, String localName) throws XMLStreamException {
    delegate.writeEmptyElement(namespaceURI, localName);
  }

  @Override
  public void writeEmptyElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
    delegate.writeEmptyElement(prefix, localName, namespaceURI);
  }

  @Override public void writeEndDocument() throws XMLStreamException {
    delegate.writeEndDocument();
  }

  @Override public void writeEntityRef(String name) throws XMLStreamException {
    delegate.writeEntityRef(name);
  }

  @Override public void writeNamespace(String prefix, String namespaceURI) throws XMLStreamException {
    delegate.writeNamespace(prefix, namespaceURI);
  }

  @Override public void writeProcessingInstruction(String target) throws XMLStreamException {
    delegate.writeProcessingInstruction(target);
  }

  @Override public void writeProcessingInstruction(String target, String data) throws XMLStreamException {
    delegate.writeProcessingInstruction(target, data);
  }

  @Override public void writeStartDocument() throws XMLStreamException {
    delegate.writeStartDocument();
  }

  @Override public void writeStartDocument(String encoding, String version) throws XMLStreamException {
    delegate.writeStartDocument(encoding, version);
  }

  @Override public void writeStartDocument(String version) throws XMLStreamException {
    delegate.writeStartDocument(version);
  }

  @Override public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {
    delegate.writeStartElement(namespaceURI, localName);
  }

  @Override
  public void writeStartElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
    delegate.writeStartElement(prefix, localName, namespaceURI);
  }
}
