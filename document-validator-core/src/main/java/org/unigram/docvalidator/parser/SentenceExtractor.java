package org.unigram.docvalidator.parser;

import java.util.List;

import org.unigram.docvalidator.DefaultSymbols;
import org.unigram.docvalidator.store.Sentence;
import org.unigram.docvalidator.util.StringUtils;

/**
 * Utility Class to extract a Sentence list from given String.
 */
public final class SentenceExtractor {
  /**
   * Default Constructor.
   */
  public SentenceExtractor() {
    this.fullStop = DefaultSymbols.get("FULL_STOP").getValue();
  }

  /**
   * Constructor.
   *
   * @param period full stop character
   */
  public SentenceExtractor(String period) {
    this.fullStop = period;
  }

  /**
   * Get Sentence lists.
   *
   * @param line            input line which can contain more than one sentences
   * @param outputSentences List of extracted sentences
   * @return remaining line
   */
  public String extract(String line, List<Sentence> outputSentences) {
    int periodPosition = StringUtils.getSentenceEndPosition(line, fullStop);
    if (periodPosition == -1) {
      return line;
    } else {
      while (true) {
        Sentence sentence = new Sentence(line.substring(0,
            periodPosition + 1), 0);
        outputSentences.add(sentence);
        line = line.substring(periodPosition + 1, line.length());
        periodPosition = StringUtils.getSentenceEndPosition(line, fullStop);
        if (periodPosition == -1) {
          return line;
        }
      }
    }
  }

  /**
   * FIXME temporary implementation! need to refactor
   * Get Sentence lists without creating the last sentence.
   * @param line input line which can contain more than one sentences
   * @param outputSentences List of extracted sentences
   * @param position line number
   * @return remaining line or last sentence
   */
  public String extractWithoutLastSentence(
      String line, List<Sentence> outputSentences,
      int position) {
    int periodPosition = StringUtils.getSentenceEndPosition(line, fullStop);
    if (periodPosition == -1) {
      return line;
    } else {
      while (true) {
        if (periodPosition == line.length() - 1) {
          return line;
        }
        Sentence sentence =
            new Sentence(line.substring(0, periodPosition + 1), position);
        outputSentences.add(sentence);
        line = line.substring(periodPosition + 1, line.length());
        periodPosition = StringUtils.getSentenceEndPosition(line, fullStop);
        if (periodPosition == -1) {
          return line;
        }
      }
    }
  }

  /**
   * Return period character.
   * @return period character
   */
  public String getFullStop() {
    return fullStop;
  }

  private String fullStop;
}
