// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CarlifeMediaInfoProto.proto

#ifndef PROTOBUF_CarlifeMediaInfoProto_2eproto__INCLUDED
#define PROTOBUF_CarlifeMediaInfoProto_2eproto__INCLUDED

#include <string>

#include <google/protobuf/stubs/common.h>

#if GOOGLE_PROTOBUF_VERSION < 2005000
#error This file was generated by a newer version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please update
#error your headers.
#endif
#if 2005000 < GOOGLE_PROTOBUF_MIN_PROTOC_VERSION
#error This file was generated by an older version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please
#error regenerate this file with a newer version of protoc.
#endif

#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/message.h>
#include <google/protobuf/repeated_field.h>
#include <google/protobuf/extension_set.h>
#include <google/protobuf/unknown_field_set.h>
// @@protoc_insertion_point(includes)

namespace com {
namespace baidu {
namespace carlife {
namespace protobuf {

// Internal implementation detail -- do not call these.
void  protobuf_AddDesc_CarlifeMediaInfoProto_2eproto();
void protobuf_AssignDesc_CarlifeMediaInfoProto_2eproto();
void protobuf_ShutdownFile_CarlifeMediaInfoProto_2eproto();

class CarlifeMediaInfo;

// ===================================================================

class CarlifeMediaInfo : public ::google::protobuf::Message {
 public:
  CarlifeMediaInfo();
  virtual ~CarlifeMediaInfo();

  CarlifeMediaInfo(const CarlifeMediaInfo& from);

  inline CarlifeMediaInfo& operator=(const CarlifeMediaInfo& from) {
    CopyFrom(from);
    return *this;
  }

  inline const ::google::protobuf::UnknownFieldSet& unknown_fields() const {
    return _unknown_fields_;
  }

  inline ::google::protobuf::UnknownFieldSet* mutable_unknown_fields() {
    return &_unknown_fields_;
  }

  static const ::google::protobuf::Descriptor* descriptor();
  static const CarlifeMediaInfo& default_instance();

  void Swap(CarlifeMediaInfo* other);

  // implements Message ----------------------------------------------

  CarlifeMediaInfo* New() const;
  void CopyFrom(const ::google::protobuf::Message& from);
  void MergeFrom(const ::google::protobuf::Message& from);
  void CopyFrom(const CarlifeMediaInfo& from);
  void MergeFrom(const CarlifeMediaInfo& from);
  void Clear();
  bool IsInitialized() const;

  int ByteSize() const;
  bool MergePartialFromCodedStream(
      ::google::protobuf::io::CodedInputStream* input);
  void SerializeWithCachedSizes(
      ::google::protobuf::io::CodedOutputStream* output) const;
  ::google::protobuf::uint8* SerializeWithCachedSizesToArray(::google::protobuf::uint8* output) const;
  int GetCachedSize() const { return _cached_size_; }
  private:
  void SharedCtor();
  void SharedDtor();
  void SetCachedSize(int size) const;
  public:

  ::google::protobuf::Metadata GetMetadata() const;

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // required string source = 1;
  inline bool has_source() const;
  inline void clear_source();
  static const int kSourceFieldNumber = 1;
  inline const ::std::string& source() const;
  inline void set_source(const ::std::string& value);
  inline void set_source(const char* value);
  inline void set_source(const char* value, size_t size);
  inline ::std::string* mutable_source();
  inline ::std::string* release_source();
  inline void set_allocated_source(::std::string* source);

  // required string song = 2;
  inline bool has_song() const;
  inline void clear_song();
  static const int kSongFieldNumber = 2;
  inline const ::std::string& song() const;
  inline void set_song(const ::std::string& value);
  inline void set_song(const char* value);
  inline void set_song(const char* value, size_t size);
  inline ::std::string* mutable_song();
  inline ::std::string* release_song();
  inline void set_allocated_song(::std::string* song);

  // required string artist = 3;
  inline bool has_artist() const;
  inline void clear_artist();
  static const int kArtistFieldNumber = 3;
  inline const ::std::string& artist() const;
  inline void set_artist(const ::std::string& value);
  inline void set_artist(const char* value);
  inline void set_artist(const char* value, size_t size);
  inline ::std::string* mutable_artist();
  inline ::std::string* release_artist();
  inline void set_allocated_artist(::std::string* artist);

  // required string album = 4;
  inline bool has_album() const;
  inline void clear_album();
  static const int kAlbumFieldNumber = 4;
  inline const ::std::string& album() const;
  inline void set_album(const ::std::string& value);
  inline void set_album(const char* value);
  inline void set_album(const char* value, size_t size);
  inline ::std::string* mutable_album();
  inline ::std::string* release_album();
  inline void set_allocated_album(::std::string* album);

  // required bytes albumArt = 5;
  inline bool has_albumart() const;
  inline void clear_albumart();
  static const int kAlbumArtFieldNumber = 5;
  inline const ::std::string& albumart() const;
  inline void set_albumart(const ::std::string& value);
  inline void set_albumart(const char* value);
  inline void set_albumart(const void* value, size_t size);
  inline ::std::string* mutable_albumart();
  inline ::std::string* release_albumart();
  inline void set_allocated_albumart(::std::string* albumart);

  // required int32 duration = 6;
  inline bool has_duration() const;
  inline void clear_duration();
  static const int kDurationFieldNumber = 6;
  inline ::google::protobuf::int32 duration() const;
  inline void set_duration(::google::protobuf::int32 value);

  // required int32 playlistNum = 7;
  inline bool has_playlistnum() const;
  inline void clear_playlistnum();
  static const int kPlaylistNumFieldNumber = 7;
  inline ::google::protobuf::int32 playlistnum() const;
  inline void set_playlistnum(::google::protobuf::int32 value);

  // required string songId = 8;
  inline bool has_songid() const;
  inline void clear_songid();
  static const int kSongIdFieldNumber = 8;
  inline const ::std::string& songid() const;
  inline void set_songid(const ::std::string& value);
  inline void set_songid(const char* value);
  inline void set_songid(const char* value, size_t size);
  inline ::std::string* mutable_songid();
  inline ::std::string* release_songid();
  inline void set_allocated_songid(::std::string* songid);

  // required int32 mode = 9;
  inline bool has_mode() const;
  inline void clear_mode();
  static const int kModeFieldNumber = 9;
  inline ::google::protobuf::int32 mode() const;
  inline void set_mode(::google::protobuf::int32 value);

  // @@protoc_insertion_point(class_scope:com.baidu.carlife.protobuf.CarlifeMediaInfo)
 private:
  inline void set_has_source();
  inline void clear_has_source();
  inline void set_has_song();
  inline void clear_has_song();
  inline void set_has_artist();
  inline void clear_has_artist();
  inline void set_has_album();
  inline void clear_has_album();
  inline void set_has_albumart();
  inline void clear_has_albumart();
  inline void set_has_duration();
  inline void clear_has_duration();
  inline void set_has_playlistnum();
  inline void clear_has_playlistnum();
  inline void set_has_songid();
  inline void clear_has_songid();
  inline void set_has_mode();
  inline void clear_has_mode();

  ::google::protobuf::UnknownFieldSet _unknown_fields_;

  ::std::string* source_;
  ::std::string* song_;
  ::std::string* artist_;
  ::std::string* album_;
  ::std::string* albumart_;
  ::google::protobuf::int32 duration_;
  ::google::protobuf::int32 playlistnum_;
  ::std::string* songid_;
  ::google::protobuf::int32 mode_;

  mutable int _cached_size_;
  ::google::protobuf::uint32 _has_bits_[(9 + 31) / 32];

  friend void  protobuf_AddDesc_CarlifeMediaInfoProto_2eproto();
  friend void protobuf_AssignDesc_CarlifeMediaInfoProto_2eproto();
  friend void protobuf_ShutdownFile_CarlifeMediaInfoProto_2eproto();

  void InitAsDefaultInstance();
  static CarlifeMediaInfo* default_instance_;
};
// ===================================================================


// ===================================================================

// CarlifeMediaInfo

// required string source = 1;
inline bool CarlifeMediaInfo::has_source() const {
  return (_has_bits_[0] & 0x00000001u) != 0;
}
inline void CarlifeMediaInfo::set_has_source() {
  _has_bits_[0] |= 0x00000001u;
}
inline void CarlifeMediaInfo::clear_has_source() {
  _has_bits_[0] &= ~0x00000001u;
}
inline void CarlifeMediaInfo::clear_source() {
  if (source_ != &::google::protobuf::internal::kEmptyString) {
    source_->clear();
  }
  clear_has_source();
}
inline const ::std::string& CarlifeMediaInfo::source() const {
  return *source_;
}
inline void CarlifeMediaInfo::set_source(const ::std::string& value) {
  set_has_source();
  if (source_ == &::google::protobuf::internal::kEmptyString) {
    source_ = new ::std::string;
  }
  source_->assign(value);
}
inline void CarlifeMediaInfo::set_source(const char* value) {
  set_has_source();
  if (source_ == &::google::protobuf::internal::kEmptyString) {
    source_ = new ::std::string;
  }
  source_->assign(value);
}
inline void CarlifeMediaInfo::set_source(const char* value, size_t size) {
  set_has_source();
  if (source_ == &::google::protobuf::internal::kEmptyString) {
    source_ = new ::std::string;
  }
  source_->assign(reinterpret_cast<const char*>(value), size);
}
inline ::std::string* CarlifeMediaInfo::mutable_source() {
  set_has_source();
  if (source_ == &::google::protobuf::internal::kEmptyString) {
    source_ = new ::std::string;
  }
  return source_;
}
inline ::std::string* CarlifeMediaInfo::release_source() {
  clear_has_source();
  if (source_ == &::google::protobuf::internal::kEmptyString) {
    return NULL;
  } else {
    ::std::string* temp = source_;
    source_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
    return temp;
  }
}
inline void CarlifeMediaInfo::set_allocated_source(::std::string* source) {
  if (source_ != &::google::protobuf::internal::kEmptyString) {
    delete source_;
  }
  if (source) {
    set_has_source();
    source_ = source;
  } else {
    clear_has_source();
    source_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
  }
}

// required string song = 2;
inline bool CarlifeMediaInfo::has_song() const {
  return (_has_bits_[0] & 0x00000002u) != 0;
}
inline void CarlifeMediaInfo::set_has_song() {
  _has_bits_[0] |= 0x00000002u;
}
inline void CarlifeMediaInfo::clear_has_song() {
  _has_bits_[0] &= ~0x00000002u;
}
inline void CarlifeMediaInfo::clear_song() {
  if (song_ != &::google::protobuf::internal::kEmptyString) {
    song_->clear();
  }
  clear_has_song();
}
inline const ::std::string& CarlifeMediaInfo::song() const {
  return *song_;
}
inline void CarlifeMediaInfo::set_song(const ::std::string& value) {
  set_has_song();
  if (song_ == &::google::protobuf::internal::kEmptyString) {
    song_ = new ::std::string;
  }
  song_->assign(value);
}
inline void CarlifeMediaInfo::set_song(const char* value) {
  set_has_song();
  if (song_ == &::google::protobuf::internal::kEmptyString) {
    song_ = new ::std::string;
  }
  song_->assign(value);
}
inline void CarlifeMediaInfo::set_song(const char* value, size_t size) {
  set_has_song();
  if (song_ == &::google::protobuf::internal::kEmptyString) {
    song_ = new ::std::string;
  }
  song_->assign(reinterpret_cast<const char*>(value), size);
}
inline ::std::string* CarlifeMediaInfo::mutable_song() {
  set_has_song();
  if (song_ == &::google::protobuf::internal::kEmptyString) {
    song_ = new ::std::string;
  }
  return song_;
}
inline ::std::string* CarlifeMediaInfo::release_song() {
  clear_has_song();
  if (song_ == &::google::protobuf::internal::kEmptyString) {
    return NULL;
  } else {
    ::std::string* temp = song_;
    song_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
    return temp;
  }
}
inline void CarlifeMediaInfo::set_allocated_song(::std::string* song) {
  if (song_ != &::google::protobuf::internal::kEmptyString) {
    delete song_;
  }
  if (song) {
    set_has_song();
    song_ = song;
  } else {
    clear_has_song();
    song_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
  }
}

// required string artist = 3;
inline bool CarlifeMediaInfo::has_artist() const {
  return (_has_bits_[0] & 0x00000004u) != 0;
}
inline void CarlifeMediaInfo::set_has_artist() {
  _has_bits_[0] |= 0x00000004u;
}
inline void CarlifeMediaInfo::clear_has_artist() {
  _has_bits_[0] &= ~0x00000004u;
}
inline void CarlifeMediaInfo::clear_artist() {
  if (artist_ != &::google::protobuf::internal::kEmptyString) {
    artist_->clear();
  }
  clear_has_artist();
}
inline const ::std::string& CarlifeMediaInfo::artist() const {
  return *artist_;
}
inline void CarlifeMediaInfo::set_artist(const ::std::string& value) {
  set_has_artist();
  if (artist_ == &::google::protobuf::internal::kEmptyString) {
    artist_ = new ::std::string;
  }
  artist_->assign(value);
}
inline void CarlifeMediaInfo::set_artist(const char* value) {
  set_has_artist();
  if (artist_ == &::google::protobuf::internal::kEmptyString) {
    artist_ = new ::std::string;
  }
  artist_->assign(value);
}
inline void CarlifeMediaInfo::set_artist(const char* value, size_t size) {
  set_has_artist();
  if (artist_ == &::google::protobuf::internal::kEmptyString) {
    artist_ = new ::std::string;
  }
  artist_->assign(reinterpret_cast<const char*>(value), size);
}
inline ::std::string* CarlifeMediaInfo::mutable_artist() {
  set_has_artist();
  if (artist_ == &::google::protobuf::internal::kEmptyString) {
    artist_ = new ::std::string;
  }
  return artist_;
}
inline ::std::string* CarlifeMediaInfo::release_artist() {
  clear_has_artist();
  if (artist_ == &::google::protobuf::internal::kEmptyString) {
    return NULL;
  } else {
    ::std::string* temp = artist_;
    artist_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
    return temp;
  }
}
inline void CarlifeMediaInfo::set_allocated_artist(::std::string* artist) {
  if (artist_ != &::google::protobuf::internal::kEmptyString) {
    delete artist_;
  }
  if (artist) {
    set_has_artist();
    artist_ = artist;
  } else {
    clear_has_artist();
    artist_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
  }
}

// required string album = 4;
inline bool CarlifeMediaInfo::has_album() const {
  return (_has_bits_[0] & 0x00000008u) != 0;
}
inline void CarlifeMediaInfo::set_has_album() {
  _has_bits_[0] |= 0x00000008u;
}
inline void CarlifeMediaInfo::clear_has_album() {
  _has_bits_[0] &= ~0x00000008u;
}
inline void CarlifeMediaInfo::clear_album() {
  if (album_ != &::google::protobuf::internal::kEmptyString) {
    album_->clear();
  }
  clear_has_album();
}
inline const ::std::string& CarlifeMediaInfo::album() const {
  return *album_;
}
inline void CarlifeMediaInfo::set_album(const ::std::string& value) {
  set_has_album();
  if (album_ == &::google::protobuf::internal::kEmptyString) {
    album_ = new ::std::string;
  }
  album_->assign(value);
}
inline void CarlifeMediaInfo::set_album(const char* value) {
  set_has_album();
  if (album_ == &::google::protobuf::internal::kEmptyString) {
    album_ = new ::std::string;
  }
  album_->assign(value);
}
inline void CarlifeMediaInfo::set_album(const char* value, size_t size) {
  set_has_album();
  if (album_ == &::google::protobuf::internal::kEmptyString) {
    album_ = new ::std::string;
  }
  album_->assign(reinterpret_cast<const char*>(value), size);
}
inline ::std::string* CarlifeMediaInfo::mutable_album() {
  set_has_album();
  if (album_ == &::google::protobuf::internal::kEmptyString) {
    album_ = new ::std::string;
  }
  return album_;
}
inline ::std::string* CarlifeMediaInfo::release_album() {
  clear_has_album();
  if (album_ == &::google::protobuf::internal::kEmptyString) {
    return NULL;
  } else {
    ::std::string* temp = album_;
    album_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
    return temp;
  }
}
inline void CarlifeMediaInfo::set_allocated_album(::std::string* album) {
  if (album_ != &::google::protobuf::internal::kEmptyString) {
    delete album_;
  }
  if (album) {
    set_has_album();
    album_ = album;
  } else {
    clear_has_album();
    album_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
  }
}

// required bytes albumArt = 5;
inline bool CarlifeMediaInfo::has_albumart() const {
  return (_has_bits_[0] & 0x00000010u) != 0;
}
inline void CarlifeMediaInfo::set_has_albumart() {
  _has_bits_[0] |= 0x00000010u;
}
inline void CarlifeMediaInfo::clear_has_albumart() {
  _has_bits_[0] &= ~0x00000010u;
}
inline void CarlifeMediaInfo::clear_albumart() {
  if (albumart_ != &::google::protobuf::internal::kEmptyString) {
    albumart_->clear();
  }
  clear_has_albumart();
}
inline const ::std::string& CarlifeMediaInfo::albumart() const {
  return *albumart_;
}
inline void CarlifeMediaInfo::set_albumart(const ::std::string& value) {
  set_has_albumart();
  if (albumart_ == &::google::protobuf::internal::kEmptyString) {
    albumart_ = new ::std::string;
  }
  albumart_->assign(value);
}
inline void CarlifeMediaInfo::set_albumart(const char* value) {
  set_has_albumart();
  if (albumart_ == &::google::protobuf::internal::kEmptyString) {
    albumart_ = new ::std::string;
  }
  albumart_->assign(value);
}
inline void CarlifeMediaInfo::set_albumart(const void* value, size_t size) {
  set_has_albumart();
  if (albumart_ == &::google::protobuf::internal::kEmptyString) {
    albumart_ = new ::std::string;
  }
  albumart_->assign(reinterpret_cast<const char*>(value), size);
}
inline ::std::string* CarlifeMediaInfo::mutable_albumart() {
  set_has_albumart();
  if (albumart_ == &::google::protobuf::internal::kEmptyString) {
    albumart_ = new ::std::string;
  }
  return albumart_;
}
inline ::std::string* CarlifeMediaInfo::release_albumart() {
  clear_has_albumart();
  if (albumart_ == &::google::protobuf::internal::kEmptyString) {
    return NULL;
  } else {
    ::std::string* temp = albumart_;
    albumart_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
    return temp;
  }
}
inline void CarlifeMediaInfo::set_allocated_albumart(::std::string* albumart) {
  if (albumart_ != &::google::protobuf::internal::kEmptyString) {
    delete albumart_;
  }
  if (albumart) {
    set_has_albumart();
    albumart_ = albumart;
  } else {
    clear_has_albumart();
    albumart_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
  }
}

// required int32 duration = 6;
inline bool CarlifeMediaInfo::has_duration() const {
  return (_has_bits_[0] & 0x00000020u) != 0;
}
inline void CarlifeMediaInfo::set_has_duration() {
  _has_bits_[0] |= 0x00000020u;
}
inline void CarlifeMediaInfo::clear_has_duration() {
  _has_bits_[0] &= ~0x00000020u;
}
inline void CarlifeMediaInfo::clear_duration() {
  duration_ = 0;
  clear_has_duration();
}
inline ::google::protobuf::int32 CarlifeMediaInfo::duration() const {
  return duration_;
}
inline void CarlifeMediaInfo::set_duration(::google::protobuf::int32 value) {
  set_has_duration();
  duration_ = value;
}

// required int32 playlistNum = 7;
inline bool CarlifeMediaInfo::has_playlistnum() const {
  return (_has_bits_[0] & 0x00000040u) != 0;
}
inline void CarlifeMediaInfo::set_has_playlistnum() {
  _has_bits_[0] |= 0x00000040u;
}
inline void CarlifeMediaInfo::clear_has_playlistnum() {
  _has_bits_[0] &= ~0x00000040u;
}
inline void CarlifeMediaInfo::clear_playlistnum() {
  playlistnum_ = 0;
  clear_has_playlistnum();
}
inline ::google::protobuf::int32 CarlifeMediaInfo::playlistnum() const {
  return playlistnum_;
}
inline void CarlifeMediaInfo::set_playlistnum(::google::protobuf::int32 value) {
  set_has_playlistnum();
  playlistnum_ = value;
}

// required string songId = 8;
inline bool CarlifeMediaInfo::has_songid() const {
  return (_has_bits_[0] & 0x00000080u) != 0;
}
inline void CarlifeMediaInfo::set_has_songid() {
  _has_bits_[0] |= 0x00000080u;
}
inline void CarlifeMediaInfo::clear_has_songid() {
  _has_bits_[0] &= ~0x00000080u;
}
inline void CarlifeMediaInfo::clear_songid() {
  if (songid_ != &::google::protobuf::internal::kEmptyString) {
    songid_->clear();
  }
  clear_has_songid();
}
inline const ::std::string& CarlifeMediaInfo::songid() const {
  return *songid_;
}
inline void CarlifeMediaInfo::set_songid(const ::std::string& value) {
  set_has_songid();
  if (songid_ == &::google::protobuf::internal::kEmptyString) {
    songid_ = new ::std::string;
  }
  songid_->assign(value);
}
inline void CarlifeMediaInfo::set_songid(const char* value) {
  set_has_songid();
  if (songid_ == &::google::protobuf::internal::kEmptyString) {
    songid_ = new ::std::string;
  }
  songid_->assign(value);
}
inline void CarlifeMediaInfo::set_songid(const char* value, size_t size) {
  set_has_songid();
  if (songid_ == &::google::protobuf::internal::kEmptyString) {
    songid_ = new ::std::string;
  }
  songid_->assign(reinterpret_cast<const char*>(value), size);
}
inline ::std::string* CarlifeMediaInfo::mutable_songid() {
  set_has_songid();
  if (songid_ == &::google::protobuf::internal::kEmptyString) {
    songid_ = new ::std::string;
  }
  return songid_;
}
inline ::std::string* CarlifeMediaInfo::release_songid() {
  clear_has_songid();
  if (songid_ == &::google::protobuf::internal::kEmptyString) {
    return NULL;
  } else {
    ::std::string* temp = songid_;
    songid_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
    return temp;
  }
}
inline void CarlifeMediaInfo::set_allocated_songid(::std::string* songid) {
  if (songid_ != &::google::protobuf::internal::kEmptyString) {
    delete songid_;
  }
  if (songid) {
    set_has_songid();
    songid_ = songid;
  } else {
    clear_has_songid();
    songid_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
  }
}

// required int32 mode = 9;
inline bool CarlifeMediaInfo::has_mode() const {
  return (_has_bits_[0] & 0x00000100u) != 0;
}
inline void CarlifeMediaInfo::set_has_mode() {
  _has_bits_[0] |= 0x00000100u;
}
inline void CarlifeMediaInfo::clear_has_mode() {
  _has_bits_[0] &= ~0x00000100u;
}
inline void CarlifeMediaInfo::clear_mode() {
  mode_ = 0;
  clear_has_mode();
}
inline ::google::protobuf::int32 CarlifeMediaInfo::mode() const {
  return mode_;
}
inline void CarlifeMediaInfo::set_mode(::google::protobuf::int32 value) {
  set_has_mode();
  mode_ = value;
}


// @@protoc_insertion_point(namespace_scope)

}  // namespace protobuf
}  // namespace carlife
}  // namespace baidu
}  // namespace com

#ifndef SWIG
namespace google {
namespace protobuf {


}  // namespace google
}  // namespace protobuf
#endif  // SWIG

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_CarlifeMediaInfoProto_2eproto__INCLUDED